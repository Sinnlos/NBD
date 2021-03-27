
object demo {



  def main(args: Array[String]): Unit = {

    val weekdaysList: List[String] = List("poniedzialek","wtorek","sroda","czwartek","piatek","sobota","niedziela")
    val productsMap : Map[String, Double] = Map("winogrona" -> 5.10, "jablko" -> 4.30, "pomarancza" -> 6.00, "banan" -> 3.40, "maliny" -> 6.70)
    val numbers :List[Int] = List(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    val numbers2 :List[Int] = List(-4,0,-3,-2,-1,0,1,2,3,0,4,5,0)
    val tpl = new Tuple3(1250, 5.10, "gruszka")

    //1.zad1
    //loops(weekdaysList)

    //1.zad2
    //println(recur1(weekdaysList, weekdaysList.length))
    //println(recur2(weekdaysList, weekdaysList.length))

    //1.zad3
    //println(recur3(weekdaysList, weekdaysList.length, ""))

    //1.zad.4a
    //fold(weekdaysList)

    //1.zad.5
    //println(productsMap.view.mapValues(_ * 0.9).toMap)

    //1.zad.6
    //writeTuple(tpl)

    //1.zad.7
    //znajdz cenę owocy po kluczu
    //println(productsMap.get("winogrona").getOrElse("owoc nie znaleziony"))
    //println(productsMap.get("arbuz").getOrElse("owoc nie znaleziony"))

    //1.zad.8
    //println(removeZero(numbers2))

    //1.zad.9
    //println(add1(numbers))

    //1.zad.10
    //println(num(numbers))

    //2.zad.1
    /*
    println(weekDaysMatching("PONIEDZIALEK"))
    println(weekDaysMatching("wtorek"))
    println(weekDaysMatching("niedziela"))
    println(weekDaysMatching("sObOtA"))
    println(weekDaysMatching("xyz"))

     */

    //2.zad.2
    /*
    var konto = new KontoBankowe()
    konto.pokazStanKonta
    konto.wplata(200)
    konto.pokazStanKonta
    konto.wyplata(150)
    konto.pokazStanKonta

    var konto2 = new KontoBankowe(2000)
    konto2.pokazStanKonta
    konto2.wplata(200)
    konto2.pokazStanKonta
    konto2.wyplata(150)
    konto2.pokazStanKonta

     */

    //2.zad.3
    /*
    var osoba1 = new Powitanie_Osoba("Patric", "Black")
    var osoba2 = new Powitanie_Osoba("Jimin", "Park")
    var osoba3 = new Powitanie_Osoba("Jackson", "Wang")
    var osoba4 = new Powitanie_Osoba("Cai", "Xukun")
    var osoba5 = new Powitanie_Osoba("Taehyung", "Kim")
    var osoba6 = new Powitanie_Osoba("Jack", "Smith")
    var osoba7 = new Powitanie_Osoba("Jacek", "Kowalski")
    var osoba8 = new Powitanie_Osoba("Adam", "Nowak")

    println(greetings(osoba1))
    println(greetings(osoba2))
    println(greetings(osoba3))
    println(greetings(osoba4))
    println(greetings(osoba5))
    println(greetings(osoba6))
    println(greetings(osoba7))
    println(greetings(osoba8))

     */

    //2.zad.4
    //multiply(sqrtfunc, 2)
    //multiply(sqrtfunc, 4)

    //2.zad.5
    /*
    var person1 = new Osoba() with Student
    println(person1.get_podatek())

    var person2 = new Osoba() with Pracownik
    person2.set_pensja(3500)
    println(person2.get_podatek())

    var person3 = new Osoba() with Nauczyciel
    person3.set_pensja(3500)
    println(person3.get_podatek())
    var person4 = new Osoba() with Student with Pracownik
    person4.set_pensja(3500)
    println(person4.get_podatek()) //wyliczy podatek tak jak dla pracownika

    var person5 = new Osoba() with Pracownik with Student
    person5.set_pensja(3500)
    println(person5.get_podatek()) //wyliczy podatek jak dla studenta - 0

     */










}

  //1.zad1
  def loops(list1 : List[String]) : Unit = {
    //1.zad.1a
    var res0 :String = ""
    for(x <- list1){
      if(res0 == ""){
        res0 += x
      }
      else{
        res0 += ("," + x)
      }
    }
    println(res0)

    //1.zad.1b
    var res1 :String = ""
    for(x <- list1; if x.substring(0,1) == "p"){
      if(res1 == ""){
        res1 += x
      }
      else{
        res1 += ("," + x)
      }
    }
    println(res1)

    //1.zad.1c
    var x1 :Int= 0
    var res2 :String = ""
    while (x1<list1.length){
      if(x1==list1.length-1){
        res2 += list1(x1)
      }
      else{
        res2 += list1(x1)+","
      }
      x1+=1
    }
    println(res2)
  }

  //1.zad.2a
  def recur1(list1 : List[String], n: Int) : String = {

    if(n == 1){
      return list1(0)
    }
    (recur1(list1, n-1) + "," + list1(n-1) )
  }

  //1.zad.2b
  def recur2(list1 : List[String], n: Int) : String = {
    if(n == 1){
      return list1(0)
    }
    (list1(n-1) + "," + recur2(list1, n-1)  )

  }

  //1.zad.3
  def recur3(list1 : List[String], n: Int, res: String) : String = {

    if(n == 0){
      return res
    }
    (recur3(list1, n-1, res = if (n==1) list1(n-1)+ res else ","+list1(n-1)+ res))
  }

  //1.zad.4
  def fold(list1 : List[String]) : Unit = {

    //1.zad.4a
    val res1 = list1.foldLeft(""){
      (x, y) => if (y!=list1.last) x + y +"," else x + y
    }
    println(res1)

    //1.zad.4b
    val res2 = list1.foldRight(""){
      (x, y) => if (x!=list1.head) "," +x + y else x + y
    }
    println(res2)

    //1.zad.4c
    val res3 = list1.foldLeft(""){
      (x, y) => if (y.substring(0,1)=="p") if (y!=list1.head) x + "," + y   else x + y else x
    }

    println(res3)

  }

  //1.zad.6
  def writeTuple(tpl : (Int, Double, String)) : Unit = {

    tpl.productIterator.foreach(println)

  }

  //1.zad.8
  def removeZero(list1: List[Int], newList: List[Int] = List.empty): List[Int] = {

    list1 match {
      case Nil    => newList // Nil is the last element of the list (empty element)
      case 0 :: list => removeZero( list, newList ) //in case its 0
      case h :: list => removeZero( list, h :: newList ) //in case something else than Nil and 0
    }

  }

  //1.zad.9
  def add1(list1 : List[Int]) : List[Int] = {

    list1.map(x => x + 1)

  }

  //1.zad.10
  def num(list1 : List[Int]) : List[Int] = {

    (list1.filter(x => x > -5 && x < 12)).map(x => x.abs)

  }

  //2.zad.1
  def weekDaysMatching(str : String) : String = {

    str.toLowerCase match {
      case "niedziela" | "sobota" => "Weekend"
      case "poniedzialek" | "wtorek" | "sroda" | "czwartek" | "piatek" => "Praca"
      case x => "Nie ma takiego dnia"

    }
  }

  //2.zad.2
  class KontoBankowe(val stanKonta : Int){

    var wplaty : Int = 0
    var wyplaty : Int = 0

    def this() = {
      this(0)
    }

    def wplata(suma : Int): Unit ={
      wplaty += suma
    }

    def wyplata(suma : Int): Unit ={
      wyplaty += suma
    }

    def pokazStanKonta: Unit ={
      var nowyStanKonta = stanKonta + wplaty - wyplaty
      println(nowyStanKonta)
    }

  }

  //2.zad.3
  class Powitanie_Osoba(val imie: String, val nazwisko: String)

  def greetings(osoba : Powitanie_Osoba) : String = {

    osoba.nazwisko match {
      case "Black" | "Smith" => "Hello, " + osoba.imie + " " + osoba.nazwisko
      case "Park" | "Kim" => "Annyeong, " + osoba.imie + " " + osoba.nazwisko
      case "Wang" | "Xukun" => "Ni hao, " + osoba.imie + " " + osoba.nazwisko
      case x => "Witaj, " + osoba.imie + " " + osoba.nazwisko

    }
  }

  //2.zad.4
  def sqrtfunc(num : Int) : Int = {
    num * num
  }

  def multiply(f: (Int) => Int, num : Int) : Unit = {
    var x = 0
    var res : Int = num

    while(x<3){
      res = f(res)
      x+=1
    }
    println(res)

  }
}
