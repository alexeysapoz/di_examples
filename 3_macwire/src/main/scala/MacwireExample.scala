import services.{DumbNotificationService, DumbTransactionProcessor, DumbTransferService, NotificationService, TransactionProcessor, TransferService}

object MacwireExample extends App {
  val transferModule = new TransferModule
  val transferService = transferModule.theTransferService
  transferService.makeTransfer(sourceAccount = "001", destinationAccount = "245", amount = 1000)
}

class TransferModule {
  import com.softwaremill.macwire._

  private lazy val theNotificationService: NotificationService = wire[DumbNotificationService]
  private lazy val theTransactionProcessor: TransactionProcessor = wire[DumbTransactionProcessor]
  lazy val theTransferService: TransferService = wire[DumbTransferService]
}