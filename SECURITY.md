# Security Notes

Bu repo egitsel ve gelistirme amaclidir.

## Secret Yonetimi

- Veritabani sifresi, API anahtari, token, private key ve benzeri gizli bilgiler repoya commit edilmemelidir.
- Lokal ortama ozel NetBeans, GlassFish ve benzeri private konfigurasyonlar versiyon kontrolu disinda tutulmalidir.
- Secret yanlislikla public repoya girdiyse, sadece dosyayi duzeltmek yeterli degildir. Secret derhal degistirilmeli ve gerekiyorsa git gecmisi temizlenmelidir.

## Mevcut Sinirlar

- Uygulamada daha ileri seviye guvenlik sertlestirmeleri henuz tamamlanmis degildir.
- Uretim kullaniminda parola hashleme, guvenli session yonetimi, yetki kontrollerinin merkezilestirilmesi ve konfigurasyonun ortam bazli ayrismasi eklenmelidir.

## Raporlama

Guvenlik acigi tespit edilirse public issue yerine repo sahibi ile dogrudan paylasilmasi daha uygundur.