@Grab(group="org.jsoup",module="jsoup",version="1.8.1")
import org.jsoup.Jsoup;



void fetch(){
	def soufang = "http://zu.sz.fang.com/house-a087/"

	this.getClass().classLoader.rootLoader.addURL(new File("jsoup-1.8.1.jar").toURL())
	println "fetch.. $soufang"
	Jsoup.connect("$soufang").get().select(".houseList dl").each {
		//#rentid_B04_01 > dd > div > p.mt5.alignR > span
		def title = it.select("dd > p.gray6.mt10 > a:nth-child(2) > span").text()
		def size = it.select("dd > p.gray6.mt5").text()[0..3]
		def price = it.select("dd >  div > p >s pan.price").text()
		println "name:$title \t\t size:$size \t price:${price}" 
		
	}
}


fetch();