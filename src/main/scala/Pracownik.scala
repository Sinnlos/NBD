trait Pracownik extends Osoba {
  var pensja: Int = 0

  def set_pensja(x: Int): Unit ={
    pensja = x
  }

  def get_pensja(): Int ={
    return pensja
  }

  override def get_podatek(): Double = {
    return (pensja * 0.2)
  }
}
