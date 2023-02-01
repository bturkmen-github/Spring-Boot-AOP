# Spring Boot Aspect Oriented Programming (AOP) Example

## AOP Nedir
	
Uygulamadaki iş mantığı ile ortak kullanılabilecek olan yapıların birbirinden ayrılarak modülerliği arttırmayı amaçlayan bir yaklaşımdır.

Bu bahsettiğimiz iş mantığından bağımsız olarak ayrılabilecek olan ortak yapılar nelerdir.
* Logging
* Caching
* Exception Handling
* Authentication
* Transaction Manager 
* vb ...

Uygulamadaki tüm katmanlar tarafından kullanılabilecek olan bu ortak yapılara **Cross-Cutting Concern** denir.

![AOP](https://2.bp.blogspot.com/-Rw0IF-Y-NR8/XN_Vo8ooaLI/AAAAAAAAF_4/6g3b8nEUN98Ba6UGZHW5OJNEDfn6tfFFgCLcBGAs/s1600/spring-aop-cross-cuttin-concerns.png)
	
#### AOP avantajları nelerdir ?

1. **Reusability :** Kod tekrarını engeller ve kodun tekrar kullanılabilirliğini arttırır.
2. **Readability :** Kod okunabilirliğini arttırır.
3. **Maintainability :** Bakım kolaylığı sağlar.

	> Don't Repeat Yourself


