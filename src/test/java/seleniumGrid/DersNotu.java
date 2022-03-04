package seleniumGrid;

public class DersNotu {
    /*SELENIUM GRID DERS NOTLARI 22/02/2022 BATCH 44
    PARALEL TESTİ NASIL YAPARSINIZ?
            1) TestNG xml files
2) Cucumber -> Maven SureFire Plugin
3) Selenium Grid
    SELENIUM GRID KULLANDIN MI? NEREDE KULLANDIN?
    Evet Kullandım. Paralel Test ve Cross Browser Test yaparken.
    CROSS BROWSER TEST NEDİR?
    Bir application’ın bir çok browser’da çalışıp çalışmadığını test etmek.
    PARALEL TEST NEDİR?
    Testleri aynı anda çalıştırmak.
    HUB NEDİR?
    Ağdaki tüm makineleri kontrol eden, yönlendiren merkezdir.
    Kullanıcın isteklerini alır, o isteklere uygun makinalara kodlarımızı gönderir ve çalıştırır.
    NODE NEDİR?
    Kodlarımızı çalıştırmak için oluşturduğumuz sanal makina ortamı.
    SELENIUM GRID’DE HANGİ DRIVER’I KULLANIYORSUN?
    RemoteWebDriver Class kullanılır.
    Desired Capabilities nedir?
    Cross Browser testlerini gerçekleştirmek için browser’ların özelliklerini ayarlamada kullanılan Selenium’da bir class’tır.
    Desired Capabilities İÇİNDE NE VAR?
            1) İşletim sistemini
2) Browser ismi
3) Browser Version
    SELENIUM GRID4 KURULUM
1) Windows: C:\ sürücüsünde SeleniumGrid isminde bir dosya olusturun.
            2) Download Selenium 4 “https://www.selenium.dev/downloads/”
            3) SeleniumGrid dosyasının içine indirdiğiniz selenium-server-4.1.2.jar dosyasını kopyalayın
4) Crome browserınızın versiyonunu kontrol edin 98.0.4758.102
            5) https://chromedriver.chromium.org/ adresine gidip 98.0.4758.102 versiyonunu indirip C:\SeleniumGrid dosyasının içine kopyalayın.
            6) https://github.com/mozilla/geckodriver/releases
    adresine gidip, işletim sisteminize uyan, geckodriver’ ı indir ve C:\SeleniumGrid dosyasına kopyala.
7) Terminali açın C:\SeleniumGrid
“java -jar selenium-server-4.1.2.jar standalone” bu kodu yazın
    C:\SeleniumGrid>java -jar selenium-server-4.1.2.jar standalone ENTER
8) “Started Selenium Standalone 4.1.2 (revision 9a5a329c5a): http://192.168.43.151:4444” mesajını almanız lazım.
            9) Browser’ı açın ve http://192.168.43.151:4444/ adresini yazıp ENTER
    NOT: Buradaki “http://192.168.43.151:4444” adresi her bilgisayarda farklı olabilir. Siz 8. maddede bilgisayarınızın sizin için oluşturduğu adresi kullanacaksınız.
    ÇALIŞTIRACAĞIMIZ KODLARI YAZMAYA BAŞLAMAK İÇİN PROJE OLUŞTURALIM
1) IntelliJ’yi açın.
            2) File -> New Project
3) Maven’ı seç
4) Name => SeleniumGrid
5) pom.xml’i aç. Aşağıdaki dependency’leri ekle
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.1.2</version>
        </dependency> */
}
