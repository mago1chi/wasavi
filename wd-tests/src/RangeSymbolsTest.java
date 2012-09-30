package WasaviTest;

import static WasaviTest.WasaviAsserts.*;
import static WasaviTest.WasaviUtils.*;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.regex.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RangeSymbolsTest extends WasaviTest {

	//

	@Test
	public void doubleQuote_All_Outer () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("0ya\"");

		assertEquals("#1", "\"def\"  ", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_All_Top () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("6|ya\"");

		assertEquals("#1", "\"def\"  ", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_All_Inner () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("8|ya\"");

		assertEquals("#1", "\"def\"  ", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_All_Bottom () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("10|ya\"");

		assertEquals("#1", "\"def\"  ", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_All_Error () {
		Wasavi.send("iabc  def  ghi\u001b");
		Wasavi.send("7|ya\"");

		assertEquals("#1", "", Wasavi.getRegister("\""));
		assertTrue("#2", Wasavi.getLastMessage().length() > 0);
	}

	//

	@Test
	public void doubleQuote_Inner_Outer () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("0yi\"");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_Inner_Top () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("6|yi\"");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_Inner_Inner () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("8|yi\"");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_Inner_Bottom () {
		Wasavi.send("iabc  \"def\"  ghi\u001b");
		Wasavi.send("10|yi\"");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void doubleQuote_Inner_Error () {
		Wasavi.send("iabc  def  ghi\u001b");
		Wasavi.send("7|yi\"");

		assertEquals("#1", "", Wasavi.getRegister("\""));
		assertTrue("#2", Wasavi.getLastMessage().length() > 0);
	}
	
	//

	@Test
	public void word_All_Outer () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("5|yaw");

		assertEquals("#1", "   def", Wasavi.getRegister("\""));
	}

	@Test
	public void word_All_Inner () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("8|yaw");

		assertEquals("#1", "def   ", Wasavi.getRegister("\""));
	}

	@Test
	public void word_All_Top () {
		Wasavi.send("iabc   def   ghi   \u001b");
		Wasavi.send("7|yaw");

		assertEquals("#1", "def   ", Wasavi.getRegister("\""));
	}

	@Test
	public void word_All_Bottom () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("9|yaw");

		assertEquals("#1", "def   ", Wasavi.getRegister("\""));
	}

	@Test
	public void word_All_Error () {
		Wasavi.send("i!@#   #+.   &*_\u001b");
		Wasavi.send("8|yaw");

		assertEquals("#1", "+", Wasavi.getRegister("\""));
	}

	//

	@Test
	public void word_Inner_Outer () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("5|yiw");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void word_Inner_Inner () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("8|yiw");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void word_Inner_Top () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("7|yiw");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void word_Inner_Bottom () {
		Wasavi.send("iabc   def   ghi\u001b");
		Wasavi.send("9|yiw");

		assertEquals("#1", "def", Wasavi.getRegister("\""));
	}

	@Test
	public void word_Inner_Error () {
		Wasavi.send("i!@#   #+.   &*_\u001b");
		Wasavi.send("8|yiw");

		assertEquals("#1", "+", Wasavi.getRegister("\""));
	}

	//

	@Test
	public void bigword_All_Outer () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("5|yaW");

		assertEquals("#1", "   d$f", Wasavi.getRegister("\""));
	}

	@Test
	public void bigword_All_Inner () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("8|yaW");

		assertEquals("#1", "d$f   ", Wasavi.getRegister("\""));
	}

	@Test
	public void bigword_All_Top () {
		Wasavi.send("ia#c   d$f   g%i   \u001b");
		Wasavi.send("7|yaW");

		assertEquals("#1", "d$f   ", Wasavi.getRegister("\""));
	}

	@Test
	public void bigword_All_Bottom () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("9|yaW");

		assertEquals("#1", "d$f   ", Wasavi.getRegister("\""));
	}

	//

	@Test
	public void bigword_Inner_Outer () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("5|yiW");

		assertEquals("#1", "d$f", Wasavi.getRegister("\""));
	}

	@Test
	public void bigword_Inner_Inner () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("8|yiW");

		assertEquals("#1", "d$f", Wasavi.getRegister("\""));
	}

	@Test
	public void bigword_Inner_Top () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("7|yiW");

		assertEquals("#1", "d$f", Wasavi.getRegister("\""));
	}

	@Test
	public void bigword_Inner_Bottom () {
		Wasavi.send("ia#c   d$f   g%i\u001b");
		Wasavi.send("9|yiW");

		assertEquals("#1", "d$f", Wasavi.getRegister("\""));
	}

	//

	@Test
	public void block_all_outer () {
		Wasavi.send("iabc ( def (ghi) jkl) mno\u001b");
		Wasavi.send("1|ya(");
		assertEquals("#1", "", Wasavi.getRegister("\""));
		assertTrue("#2", Wasavi.getLastMessage().length() > 0);
	}

	@Test
	public void block_all_top () {
		Wasavi.send("iabc ( def (ghi) jkl) mno\u001b");
		Wasavi.send("5|ya(");

		assertEquals("#1", "( def (ghi) jkl)", Wasavi.getRegister("\""));
	}

	@Test
	public void block_all_inner () {
		Wasavi.send("iabc ( def (ghi) jkl) mno\u001b");
		Wasavi.send("8|ya(");

		assertEquals("#1", "( def (ghi) jkl)", Wasavi.getRegister("\""));
	}

	@Test
	public void block_all_bottom () {
		Wasavi.send("iabc ( def (ghi) jkl) mno\u001b");
		Wasavi.send("20|ya(");

		assertEquals("#1", "( def (ghi) jkl)", Wasavi.getRegister("\""));
	}

	@Test
	public void block_all_error () {
		Wasavi.send("iabc ( def (ghi) jkl mno\u001b");
		Wasavi.send("8|ya(");

		assertEquals("#1", "", Wasavi.getRegister("\""));
		assertTrue("#2", Wasavi.getLastMessage().length() > 0);
	}
}

/* vim:set ts=4 sw=4 fileencoding=UTF-8 fileformat=unix filetype=java : */
