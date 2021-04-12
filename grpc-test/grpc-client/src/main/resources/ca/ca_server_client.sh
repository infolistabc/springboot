#!/bin/bash

echo "Generating ca certificates"
openssl genrsa -out ca.key 1024
openssl req -new -key ca.key -out ca.csr -subj "/CN=localhost"
openssl x509 -req -in ca.csr -signkey ca.key -out ca.crt -days 3650

echo "Generating client certificates"
openssl genrsa -out client.key 1024
openssl rsa -in client.key -pubout -out client.pem
openssl req -new -key client.key -out client.csr -subj "/CN=localhost"
openssl x509 -req -CA ca.crt -CAkey ca.key -CAcreateserial -in client.csr -out client.crt -days 3650

echo "Generating server certificates"
openssl genrsa -out server.key 1024
openssl rsa -in server.key -pubout -out server.pem
openssl req -new -key server.key -out server.csr -subj "/CN=localhost"
openssl x509 -req -CA ca.crt -CAkey ca.key -CAcreateserial -in server.csr -out server.crt -days 3650

echo "Generating trustCertCollection"
rm trusted-servers-collection
rm trusted-clients-collection
cat server.crt ca.crt >> trusted-servers-collection
cat client.crt ca.crt >> trusted-clients-collection

echo "--- DONE ---"