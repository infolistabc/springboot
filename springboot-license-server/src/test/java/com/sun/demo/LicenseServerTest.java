/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseTest.java
 * Date: 2020-03-26
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo;

import com.sun.demo.util.LicenseServer;

import java.io.File;
import java.util.Base64;
import java.util.Date;

/**
 * @author 三刀
 * @version V1.0 , 2020/3/26
 */
public class LicenseServerTest {
    public static void main(String[] args) throws Exception {

        LicenseServer server = new LicenseServer(new File("source.txt"), new File("license.txt"));
        //加密内容
        String content = "加密信息字符串";

        String privateKey1 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMaMKgtamJhtyI/u1i6igm3bmx2r5vcJolvlUfIhdQ4MafuSQKftgL+yNlh5XEtbtTrer3vcSNwHDD4tDwSeG8vk1FM2iNlH9GNpMR4YHdc4gB+fB/0GuTVf/OIViPNkVQyOOgwQjxwZYEwqe38ocKgRRm/cwioy4rf4y49Mua+xAgMBAAECgYA+T88CMTSi4hGH2pUtnaMBh2JvNXwPG97wqE/HheiOuCaq5YOVMFyvzOZxbeUhYW7HQwwf+0qCg1O8T7fe4yAllvDS8+pZxSkjwwQAydVFJitmwlWinp8XkgPwaXD3664EiBklI+CbSCVjLjAGAmgnCJ5C1r17IR9rokpaGhMD4QJBAP3cSR9CZxVeVwU/5CZZ3Q70udtldnrPPqGhK7hUwC7KJ76nPk07bzbtq6CJtBL73CcFk3AqnpFOIE0qLG59PYsCQQDIOInh8CVVf+6RDSilUXtdNzKcvz2B1fjrnrG3f6ilfMB9jg8FEpDLvKrZj/YRmIZncwCbMBETQpXbWb05euczAkAsTT4hi2gL7ZvIGb9KBhKy4nhw1kMX6YTnlgXYNEoZoEPRXMRdnAqrjkyORpm7WmKwGKQDRhzIBNdUQBDi805DAkEAsKtS3w5rovnzpAIcb2Nqm2HtQupsd3g64I1y+xul0AA4SZFkJ3GuWlfr2XVyByyyy+1qB4VuS7RhTt/sXB/aiQJAZwR77lF/jICcmFxRPMa0Jj+/gPO892WQ8B6mKEVK8S/aimxHUErVviM6eqeTBuS5HnKGtlrJLf4ABBCRatBRow==";
        //私钥
        byte[] privateKey = Base64.getDecoder().decode(privateKey1);

        server.createLicense(content.getBytes(), new Date(System.currentTimeMillis() + 60 * 100000), privateKey);
    }
}
