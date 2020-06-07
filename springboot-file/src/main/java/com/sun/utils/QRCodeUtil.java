package com.sun.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

/**
 * 二维码工具类
 *
 */
public class QRCodeUtil {

    private static final int QRCOLOR = 0xFF000000; // 默认是黑色
    private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色
    private static final int WIDTH = 400; // 二维码宽
    private static final int HEIGHT = 400; // 二维码高
    /**用于设置QR二维码参数
     * com.google.zxing.EncodeHintType：编码提示类型,枚举类型
     * EncodeHintType.CHARACTER_SET：设置字符编码类型
     * EncodeHintType.ERROR_CORRECTION：设置误差校正
     *      ErrorCorrectionLevel：误差校正等级，L = ~7% correction、M = ~15% correction、Q = ~25% correction、H = ~30% correction
     *      不设置时，默认为 L 等级，等级不一样，生成的图案不同，但扫描的结果是一样的
     * EncodeHintType.MARGIN：设置二维码边距，单位像素，值越小，二维码距离四周越近
     * */
    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;
        {
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置编码方式
            put(EncodeHintType.MARGIN, 0);
        }
    };
    public static BufferedImage drawLogoQRCode(File logoFile, String qrUrl, String note) {//图片文件   二维码储存地址  网页路径                    二维码说明
        try {
            /**
             * MultiFormatWriter:多格式写入，这是一个工厂类，里面重载了两个 encode 方法，用于写入条形码或二维码
             *      encode(String contents,BarcodeFormat format,int width, int height,Map<EncodeHintType,?> hints)
             *      contents:条形码/二维码内容
             *      format：编码类型，如 条形码，二维码 等
             *      width：码的宽度
             *      height：码的高度
             *      hints：码内容的编码类型
             * BarcodeFormat：枚举该程序包已知的条形码格式，即创建何种码，如 1 维的条形码，2 维的二维码 等
             * BitMatrix：位(比特)矩阵或叫2D矩阵，也就是需要的二维码
             */
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            /**参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
             * java.awt.image.BufferedImage：具有图像数据的可访问缓冲图像，实现了 RenderedImage 接口
             * BitMatrix 的 get(int x, int y) 获取比特矩阵内容，指定位置有值，则返回true，将其设置为前景色，否则设置为背景色
             * BufferedImage 的 setRGB(int x, int y, int rgb) 方法设置图像像素
             *      x：像素位置的横坐标，即列
             *      y：像素位置的纵坐标，即行
             *      rgb：像素的值，采用 16 进制,如 0xFFFFFF 白色
             */
            BitMatrix bm = multiFormatWriter.encode(qrUrl, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
                }
            }
            int width = image.getWidth();
            int height = image.getHeight();
            if (Objects.nonNull(logoFile) && logoFile.exists()) {
                // 构建绘图对象
                Graphics2D g = image.createGraphics();
                // 读取Logo图片
                BufferedImage logo = ImageIO.read(logoFile);
                // 开始绘制logo图片
                g.drawImage(logo, width * 2 / 5, height * 2 / 5, width * 2 / 10, height * 2 / 10, null);
                g.dispose();
                logo.flush();
            }

            // 自定义文本描述
            if (StringUtils.isNotEmpty(note)) {
                // 新的图片，把带logo的二维码下面加上文字
                BufferedImage outImage = new BufferedImage(400, 445, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D outg = outImage.createGraphics();
                outg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                // 画二维码到新的面板
                outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
                // 画文字到新的面板
                outg.setColor(Color.BLACK);
                outg.setFont(new Font("楷体", Font.BOLD, 20)); // 字体、字型、字号
                int strWidth = outg.getFontMetrics().stringWidth(note);
                if (strWidth > 399) {
                  //长度过长就截取前面部分
                    // 长度过长就换行
                    String note1 = note.substring(0, note.length() / 2);
                    String note2 = note.substring(note.length() / 2, note.length());
                    int strWidth1 = outg.getFontMetrics().stringWidth(note1);
                    int strWidth2 = outg.getFontMetrics().stringWidth(note2);
                    outg.drawString(note1, 200 - strWidth1 / 2, height + (outImage.getHeight() - height) / 2+12);
                    BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                    Graphics2D outg2 = outImage2.createGraphics();
                    outg2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                    outg2.setColor(Color.BLACK);
                    outg2.setFont(new Font("楷体", Font.BOLD, 20)); // 字体、字型、字号

                    outg2.drawString(note2, 200 - strWidth2 / 2, outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight()) / 2 );
                    outg2.dispose();
                    outImage2.flush();
                    outImage = outImage2;
                } else {
                      outg.drawString(note, 200 - strWidth / 2, height + (outImage.getHeight() - height) / 2+12);
                }
                //outg.drawString(note, 200 - strWidth / 2, height + (outImage.getHeight() - height) / 2); // 画文字
                outg.dispose();
                outImage.flush();
                image = outImage;
            }

            image.flush();
            return image;
            /**
             * 区别就是以一句，输出到输出流中，如果第三个参数是 File，则输出到文件中
             */
            //ImageIO.write(image, "png", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
