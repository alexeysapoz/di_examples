package services

class DumbTransferService (transactionProcessor: TransactionProcessor,
                           notificationService: NotificationService) extends TransferService {
  override def makeTransfer(sourceAccount: String,
                            destinationAccount: String,
                            amount: Int): Unit = {
    transactionProcessor.makeTransaction(sourceAccount, destinationAccount, amount)
    val amountStr = (amount/100).toString
    notificationService.sendNotification(sourceAccount, s"Списано $amountStr рублей")
    notificationService.sendNotification(destinationAccount, s"Пополнение на $amountStr рублей")
  }
}

class DumbTransactionProcessor extends TransactionProcessor {
  override def makeTransaction(sourceAccount: String,
                               destinationAccount: String,
                               amount: Int): Unit =
    println(s"${amount/100} rub transferred from account $sourceAccount to account $destinationAccount")
}

class DumbNotificationService extends NotificationService {
  def sendNotification(receiverAccount: String, text: String): Unit =
    println(s"Sending message '$text' to account's $receiverAccount owner")
}