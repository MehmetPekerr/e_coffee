# e_coffee

e_coffee, Jakarta EE 10 tabanli bir kahve satis ve yonetim uygulamasidir. Proje, bir kahve magazasi senaryosu uzerinden urun, kategori, sepet, siparis, odeme, fatura, kullanici ve rol/izin yonetimi gibi temel e-ticaret akislarini JSF arayuzu ve JPA tabanli veri katmani ile ele alir.

## Proje Amaci

Bu repo, hem kullaniciya donuk sayfalari hem de yonetim tarafindaki CRUD akislarini tek bir calisma alani icinde toplar. Proje yapisi, Jakarta Faces ile arayuz gelistirme ve JPA/EJB ile veri erisimi konularini uygulamali gostermek icin duzenlenmistir.

## Moduller

### 1. JPA/JPAe_coffee

Veri erisim ve is mantigi katmanini icerir.

- Entity siniflari: adres, kullanici, urun, kategori, siparis, odeme, fatura, rol ve izin modelleri
- DAO siniflari: ilgili tablolar icin temel CRUD islemleri
- Controller/Bean siniflari: JSF managed bean yapisi uzerinden ekran akislari
- Converter siniflari: JSF secim ve donusum islemleri
- persistence.xml: Jakarta Persistence ayarlari

### 2. JSF/e_coffee

Sunum katmanini icerir.

- Ana sayfa, giris, kayit, magaza, sepet ve admin ekranlari
- Facelets template yapisi
- Kaynak dosyalar: CSS, JS ve gorseller
- NetBeans uzerinden deploy edilebilen web modulu

## Kullanilan Teknolojiler

- Java 21
- Jakarta EE 10
- JSF (Jakarta Faces)
- JPA
- EJB
- Facelets
- GlassFish Server
- PostgreSQL surucusu
- Apache Ant / NetBeans proje yapisi

## Proje Yapisi

```text
e_coffee/
  e_coffee/
    JPA/
      JPAe_coffee/
    JSF/
      e_coffee/
```

## One Cikan Alanlar

- Kahve urunleri ve kategorileri icin temel katalog yapisi
- Kullanici, rol ve izin yonetimi
- Sepet, siparis, odeme ve fatura akislarina ait veri modelleri
- Belge yukleme senaryosu icin ayri dokuman yonetimi
- Template tabanli JSF sayfa organizasyonu

## Gelistirme Ortami

Projeyi calistirmadan once asagidaki ortam hazir olmalidir:

1. Java 21 kurulu olmali.
2. GlassFish 7 veya Jakarta EE 10 uyumlu bir uygulama sunucusu hazir olmali.
3. PostgreSQL JDBC surucusu NetBeans kutuphanelerine eklenmeli.
4. NetBeans uzerinden her iki modul ayri web projesi olarak acilmali.
5. Veritabani ve datasource ayarlari, [e_coffee/JPA/JPAe_coffee/src/conf/persistence.xml](e_coffee/JPA/JPAe_coffee/src/conf/persistence.xml) dosyasindaki persistence birimi ile uyumlu olacak sekilde yapilandirilmali.

## Calistirma Adimlari

1. NetBeans ile [e_coffee/JPA/JPAe_coffee](e_coffee/JPA/JPAe_coffee) ve [e_coffee/JSF/e_coffee](e_coffee/JSF/e_coffee) projelerini acin.
2. GlassFish sunucusunu IDE icinde tanimlayin.
3. PostgreSQL surucusunun proje kutuphanelerinde gorundugunden emin olun.
4. [e_coffee/JPA/JPAe_coffee/web/WEB-INF/glassfish-resources.xml](e_coffee/JPA/JPAe_coffee/web/WEB-INF/glassfish-resources.xml) icindeki CHANGE_ME alanlarini kendi ortaminiza gore guncelleyin.
5. Once derleme alin, sonra uygulamayi GlassFish uzerine deploy edin.

## Guvenlik

- Repo icinde gercek veritabani sifresi, lokal IDE ayarlari ve makineye ozel private dosyalar tutulmamasi hedeflenir.
- Datasource kullanici adi ve parola gibi degerleri commit etmeden once placeholder veya ortam bazli konfigrasyon ile yonetin.
- Public repoya secret girmesi durumunda, degeri sadece dosyadan silmek yeterli degildir; ilgili secret derhal rotate edilmelidir.
- Mevcut uygulama egitsel niteliktedir; uretim icin parola hashleme, yetki sertlestirme ve config ayrisma gereklidir.

## Notlar

- Repo icinde yerel build ciktilari, WAR dosyalari ve NetBeans private ayarlari commit edilmez.
- Bu tercih, depoyu temiz tutmak ve makineye ozel yollarin paylasilmasini engellemek icindir.
- Proje, egitsel ve gelistirme odakli bir yapiya sahiptir; uretim ortami icin ek guvenlik, dogrulama ve konfigrasyon iyilestirmeleri gerekebilir.

## Lisans

Bu repo icin ayri bir lisans dosyasi tanimlanmamistir. Gerekirse daha sonra LICENSE dosyasi eklenebilir.
