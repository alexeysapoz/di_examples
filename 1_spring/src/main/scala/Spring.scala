import org.springframework.context.annotation.{AnnotationConfigApplicationContext, ComponentScan, Configuration}
import services.TransferService

object Spring extends App {
  val ctx = new AnnotationConfigApplicationContext
  ctx.register(classOf[ApplicationContext])
  ctx.refresh()

  val a = ctx.getBean(classOf[TransferService])
  a.makeTransfer(sourceAccount = "001", destinationAccount = "245", amount = 1000)
}

@Configuration
@ComponentScan(basePackages = Array("services"))
class ApplicationContext


