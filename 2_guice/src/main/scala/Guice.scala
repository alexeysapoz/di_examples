import com.google.inject.{AbstractModule, Guice, Injector}
import net.codingwell.scalaguice.ScalaModule
import services.{DumbNotificationService, DumbTransactionProcessor, DumbTransferService, NotificationService, TransactionProcessor, TransferService}

object GuiceExample extends App {
  val injector = Guice.createInjector(new TransferModule)
  val transferService = injector.getInstance(classOf[TransferService])
  transferService.makeTransfer(sourceAccount = "001", destinationAccount = "245", amount = 1000)
}

class TransferModule extends AbstractModule with ScalaModule {
  override protected def configure(): Unit = {
    bind[NotificationService].to[DumbNotificationService]
    bind[TransactionProcessor].to[DumbTransactionProcessor]
    bind[TransferService].to[DumbTransferService]
  }
}