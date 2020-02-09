package services

trait TransferService {
  def makeTransfer(sourceAccount: String, destinationAccount: String, amount: Int): Unit
}
