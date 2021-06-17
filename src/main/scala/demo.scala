
object demo {



  def main(args: Array[String]): Unit = {

    val weekdaysList: List[String] = List("poniedzialek","wtorek","sroda","czwartek","piatek","sobota","niedziela")
    val productsMap : Map[String, Double] = Map("winogrona" -> 5.10, "jablko" -> 4.30, "pomarancza" -> 6.00, "banan" -> 3.40, "maliny" -> 6.70)
    val numbers :List[Int] = List(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    val numbers2 :List[Int] = List(-4,0,-3,-2,-1,0,1,2,3,0,4,5,0)
    val tpl = new Tuple3(1250, 5.10, "gruszka")



    //1.zad1
    println(loops1(weekdaysList))
    println(loops2(weekdaysList))
    println(loops3(weekdaysList))


    //1.zad2
    println(recur1(weekdaysList))

    println(recur2(weekdaysList))

    //1.zad3
    println(recur3(weekdaysList, ""))


    //1.zad.4a
    println(fold1(weekdaysList))
    println(fold2(weekdaysList))
    println(fold3(weekdaysList))

    //1.zad.5
    println(productsMap.view.mapValues(_ * 0.9).toMap)

    //1.zad.6
    println(writeTuple(tpl))

    //1.zad.7
    //znajdz cenę owocy po kluczu
    println(productsMap.get("winogrona").getOrElse("owoc nie znaleziony"))
    println(productsMap.get("arbuz").getOrElse("owoc nie znaleziony"))

    //1.zad.8
    println(removeZero(numbers2))

    //1.zad.9
    println(add1(numbers))

    //1.zad.10
    println(num(numbers))

    //2.zad.1

    println(weekDaysMatching("PONIEDZIALEK"))
    println(weekDaysMatching("wtorek"))
    println(weekDaysMatching("niedziela"))
    println(weekDaysMatching("sObOtA"))
    println(weekDaysMatching("xyz"))



    //2.zad.2

    var konto = new KontoBankowe()
    println(konto.get_stanKonta())
    konto.wplata(200)
    println(konto.get_stanKonta())
    konto.wyplata(150)
    println(konto.get_stanKonta())
    konto.wyplata(100)
    println(konto.get_stanKonta())

    var konto2 = new KontoBankowe(2000)
    println(konto2.get_stanKonta())
    konto2.wplata(200)
    println(konto2.get_stanKonta())
    konto2.wyplata(150)
    println(konto2.get_stanKonta())
    konto2.wyplata(100)
    println(konto2.get_stanKonta())


    //2.zad.3

    var osoba1 = new Powitanie_Osoba("Jimin", "Park")
    var osoba2 = new Powitanie_Osoba("Cai", "Xukun")
    var osoba3 = new Powitanie_Osoba("Jack", "Smith")
    var osoba4 = new Powitanie_Osoba("Jacek", "Kowalski")

    println(greetings(osoba1))
    println(greetings(osoba2))
    println(greetings(osoba3))
    println(greetings(osoba4))



    //2.zad.4
    println(multiply(sqrtfunc, 2))
    println(multiply(sqrtfunc, 4))

    //2.zad.5

    var person1 = new Osoba("Adam", "Adamski") with Student
    println(person1.podatek)

    var person2 = new Osoba("Jack", "Smith") with Pracownik
    person2.pensja = 4000
    println(person2.podatek)

    var person3 = new Osoba("Alice", "Swan") with Nauczyciel
    person3.pensja = 4000
    println(person3.podatek)

    var person4 = new Osoba("Cai", "Xukun") with Student with Pracownik
    person4.pensja = 4000
    println(person4.podatek) //wyliczy podatek tak jak dla pracownika

    var person5 = new Osoba("Jimin", "Park") with Pracownik with Student
    person5.pensja = 4000
    println(person5.podatek) //wyliczy podatek jak dla studenta - 0














}

  //1.zad1
  def loops1(list1 : List[String]) : String = {
    //1.zad.1a
    var res0: String = ""
    for (x <- list1) {
      if (res0 == "") {
        res0 += x
      }
      else {
        res0 += ("," + x)
      }
    }
    return res0
  }

  def loops2(list1 : List[String]) : String = {
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
    return res1
  }

  def loops3(list1 : List[String]) : String = {
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
    return res2
  }


  //1.zad.2a
  def recur1(list1 : List[String], newList: List[String] = List.empty) : String = {
    list1 match{
      case Nil => loops1(newList.reverse)
      case h :: list => recur1(list, h :: newList)
    }

  }
  //1.zad.2b
  def recur2(list1 : List[String], newList: List[String] = List.empty) : String = {
    list1 match{
      case Nil => loops1(newList)
      case h :: list => recur2(list, h :: newList)
    }

  }

  //1.zad.3
  def recur3(list1 : List[String], res: String, newList: List[String] = List.empty) : String = {

    list1 match{
      case Nil => loops1(newList.reverse)
      case h :: list => recur3(list, res, h :: newList)
    }

  }

  //1.zad.4
  def fold1(list1 : List[String]) : String = {

    //1.zad.4a
    val res1 = list1.foldLeft("") {
      (x, y) => if (y != list1.last) x + y + "," else x + y
    }
    return res1
  }

  def fold2(list1 : List[String]) : String = {
    //1.zad.4b
    val res2 = list1.foldRight(""){
      (x, y) => if (x!=list1.head) "," +x + y else x + y
    }
    return res2

  }

  def fold3(list1 : List[String]) : String = {
    //1.zad.4c
    val res3 = list1.foldLeft(""){
      (x, y) => if (y.substring(0,1)=="p") if (y!=list1.head) x + "," + y   else x + y else x
    }

    return res3

  }


  //1.zad.6
  def writeTuple(tpl : (Int, Double, String)) : String = {

    var str: String = ""
    tpl.productIterator.foreach(str += _ + "\n")

    return str
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

    (list1.filter(x => x >= -5 && x <= 12)).map(x => x.abs)

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
  class KontoBankowe(){

    private var stanKonta: Double = 0

    def this(n: Double) = {
      this()
      stanKonta = n
    }

    def get_stanKonta(): Double= stanKonta

    def wplata(x: Double): Unit = {
      stanKonta += x
    }

    def wyplata(x : Double): Unit = {
      if (x <= stanKonta){
        stanKonta -= x
      }else{
        println("Podana kwota wypłaty jest większa niz dostępny stan konta")
      }
    }

  }

  //2.zad.3
  case class Powitanie_Osoba(val imie: String, val nazwisko: String)

  def greetings(osoba : Powitanie_Osoba) : String = osoba match {
      case Powitanie_Osoba("Jack","Smith")  => "Hello, "+ osoba.imie + " "+ osoba.nazwisko
      case Powitanie_Osoba("Jimin","Park") => "Annyeong, "+ osoba.nazwisko + " "+ osoba.imie
      case Powitanie_Osoba("Cai","Xukun") => "Ni hao, "+ osoba.imie + " "+ osoba.nazwisko
      case _ => "Witaj, " + osoba.imie + " "+ osoba.nazwisko

    }


  //2.zad.4
  def sqrtfunc(num : Int) : Int = {
    num * num
  }

  def multiply(f: (Int) => Int, num : Int) : Int = {
    var x = 0
    var res : Int = num

    res = f(f(f(res)))

    return res

  }
}
