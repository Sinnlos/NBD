trait Pracownik extends Osoba {
  var pensja: Int = 0

  override def podatek: Double = {
    this.pensja * 0.2
  }
}
