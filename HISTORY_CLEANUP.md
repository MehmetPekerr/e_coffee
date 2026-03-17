# Git History Cleanup

Bu repo icin en hizli yontem, gecmisi filtrelemek yerine temiz durumdaki calisma agacindan main dalini tek commit olarak yeniden yazmaktir.

Bu yontem su durum icin uygundur:

- Secret artik dosyalardan kaldirildiysa
- Eski commit gecmisini koruma zorunlulugu yoksa
- Public repoda sızan eski commitleri referanslardan dusurmek istiyorsaniz

## Onemli

- Bu islem history rewrite yapar.
- Force push gerektirir.
- Repo ile calisan baska biri varsa yeniden clone etmesi gerekir.
- Secret daha once sızdıysa once secret rotate edilmelidir.

## Onerilen Hızlı Yontem

PowerShell icinde repo kokunde calistirin:

```powershell
git checkout --orphan clean-main
git add .
git commit -m "Initial public release of e_coffee"
git branch -D main
git branch -m main
git push -f origin main
git push origin --delete master
```

## Ne Yapar

- Yeni bir gecmis baslatir
- Su anki temiz dosya durumunu tek commit yapar
- Eski main commit zincirini referanssiz birakir
- Varsa remote master dalini siler

## Sonrasi

Asagidaki komutlarla sonucu kontrol edin:

```powershell
git log --oneline --decorate --all
git branch -a
```

GitHub uzerinde de su kontrolleri yapin:

- Varsayilan dal main olsun
- Eski master dali kalmasin
- Secret iceren dosyanin eski hali arayuzde gorunmesin

## Daha Sert Temizlik Gerekirse

Eger eski commit hash'leri daha once paylasildiysa veya daha ileri seviye temizlik istiyorsaniz, repo tamamen silinip yeniden olusturulabilir ya da git-filter-repo ile profesyonel history rewrite uygulanabilir.