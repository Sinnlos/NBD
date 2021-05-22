trait Nauczyciel extends Osoba with Pracownik {
  override def podatek: Double = {
    this.pensja * 0.1
  }
}
