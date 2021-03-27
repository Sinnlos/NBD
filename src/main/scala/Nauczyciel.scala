trait Nauczyciel extends Osoba with Pracownik {
  override def get_podatek(): Double = {
    return (pensja * 0.1)
  }
}
