package services

trait TransactionProcessor {
  def makeTransaction(sourceAccount: String, destinationAccount: String, amount: Int): Unit
}
