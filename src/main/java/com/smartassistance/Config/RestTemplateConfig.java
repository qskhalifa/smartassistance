package com.smartassistance.Config;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Qualifier("uninstalled-self-signed")
    public RestTemplate restTemplateForUninstalledSelfSigned() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        TrustStrategy trustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(java.security.cert.X509Certificate[] x509Certificates, String authType) throws java.security.cert.CertificateException {
                return true;
            }
        };

        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, trustStrategy).build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());

        CloseableHttpClient closeableHttpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();

        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setHttpClient(closeableHttpClient);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
        return restTemplate;
    }


    @Bean
    @Qualifier("installed-self-signed")
    public RestTemplate restTemplateForInstalledSelfSigned() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        /*
        The certificate will be trusted because it is in the Java KeyStore, but the hostname verification needs to be skipped.
        The installation command:-
        keytool -importkeystore -deststorepass changeit -destkeystore "{JRE_PATH}/lib/security/cacerts" -srckeystore "{PATH-OF-CERT}/interface-ssc.p12" -srcstoretype pkcs12 -srcstorepass {CERT-PASS} -alias interface-ssc
         */
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setHttpClient(closeableHttpClient);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
        return restTemplate;
    }


    @Bean
    @Qualifier("ca-signed")
    public RestTemplate restTemplateForCASigned() {
        return new RestTemplate();
    }
}
