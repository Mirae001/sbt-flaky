import java.io.{File, PrintWriter}

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source;

class FilesUtilsSpec extends FlatSpec with Matchers with LazyLogging {

  private val file = File.createTempFile("test", "file")

  it should "write to file" in {
    val writer = new PrintWriter(file)
    (1 to 1800).foreach { i =>
      writer.println(s"line $i")
    }
  }

  it should "process file" in {
    Source.fromFile(file).getLines().length shouldBe 923
  }
}
