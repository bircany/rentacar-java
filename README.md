# RentACar Otomasyonu

## Proje Tanımı
RentACar Otomasyonu, araç kiralama şirketleri için geliştirilmiş kapsamlı bir yönetim sistemidir. Sistem, müşteri yönetimi, araç envanteri, kiralama sözleşmeleri, şube yönetimi ve çalışan yönetimi gibi temel araç kiralama operasyonlarını otomatize etmek için tasarlanmıştır.

## Kullanılan Teknolojiler

- **Java 17**: Ana programlama dili
- **Spring Boot (2.7.8)**: Uygulama çerçevesi
- **Spring Data JPA**: Veritabanı işlemleri için ORM çözümü
- **Spring Security**: Yetkilendirme ve kimlik doğrulama
- **MySQL**: Veritabanı yönetim sistemi
- **Swing/SwingX**: Masaüstü uygulama arayüzü
- **Lombok**: Boilerplate kod azaltma
- **SpringDoc OpenAPI**: API dokümantasyonu

## Sistemin Özellikleri

### Araç Yönetimi
- Araç ekleme, düzenleme ve silme
- Araç türleri ve modelleri yönetimi
- Araç durum takibi (müsait, kiralanmış, bakımda)
- Araç servis kayıtları takibi

### Müşteri Yönetimi
- Müşteri bilgileri kaydı ve yönetimi
- Müşteri kiralama geçmişi takibi

### Kiralama İşlemleri
- Kiralama sözleşmeleri oluşturma
- Ödeme işlemleri
- Araç iade işlemleri

### Şube Yönetimi
- Şube bilgileri ve envanteri
- Şubeler arası araç transferi

### Çalışan Yönetimi
- Çalışan kaydı ve rollerinin belirlenmesi
- Çalışan işlem takibi

### Sigorta Yönetimi
- Araç sigortalarının takibi
- Sigorta yenileme hatırlatmaları

## Sistem Mimarisi

Uygulama, modern bir çok katmanlı mimari ile geliştirilmiştir:

- **Model Katmanı**: Veritabanı entity'leri
- **Repository Katmanı**: Veritabanı erişim katmanı
- **Service Katmanı**: İş mantığı
- **Controller Katmanı**: REST API endpoint'leri
- **UI Katmanı**: Swing tabanlı kullanıcı arayüzü

## Kurulum

### Gereksinimler
- Java 17 veya üzeri
- Maven
- MySQL veritabanı

### Adımlar
1. Projeyi klonlayın:
   ```
   git clone https://github.com/kullaniciadi/rentacar-java.git
   ```

2. Veritabanını oluşturun:
   ```
   CREATE DATABASE rentacar;
   ```

3. `application.properties` dosyasında veritabanı yapılandırmasını düzenleyin.

4. Projeyi derleyin ve çalıştırın:
   ```
   mvn clean install
   mvn spring-boot:run
   ```

## Katkıda Bulunma
1. Bu repo'yu fork edin
2. Feature branch oluşturun (`git checkout -b feature/AmazingFeature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add some AmazingFeature'`)
4. Branch'inize Push edin (`git push origin feature/AmazingFeature`)
5. Pull Request açın

## Lisans
Bu proje [MIT Lisansı](LICENSE) altında lisanslanmıştır.
