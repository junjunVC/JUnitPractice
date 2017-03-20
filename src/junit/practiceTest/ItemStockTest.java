package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import junit.practice.ItemStock;
import junit.practice.Item;

@RunWith(Enclosed.class)
public class ItemStockTest {

	public static class 初期状態の場合 {
		ItemStock sut;
		Item book;

		@Before
		public void setUp() throws Exception {
			book = new Item("book",3800);
			sut = new ItemStock();
		}

		@Test
		public void getNumは初期状態で0を返す() throws Exception {
			assertThat(sut.getNum(book),is(0));
		}

		@Test
		public void addでbookを追加するとgetNumで1を返す() throws Exception {
			sut.add(book);
			assertThat(sut.getNum(book),is(1));
		}
	}

	public static class bookが1つ追加されている場合 {
		ItemStock sut;
		Item book;

		@Before
		public void setUp() throws Exception {
			book = new Item("book",3900);
			sut = new ItemStock();
			sut.add(book);
		}

		@Test
		public void getNumはbookが1つ追加されている状態で1を返す() throws Exception {
			assertThat(sut.getNum(book),is(1));
		}

		@Test
		public void addでbookを追加するとgetNumで2を返す() throws Exception {
			sut.add(book);
			assertThat(sut.getNum(book), is(2));
		}

		@Test
		public void addでpenを追加するとgetNumで1を返す() throws Exception {
			Item pen = new Item("pen",100);
			sut.add(pen);
			assertThat(sut.getNum(pen),is(1));
		}
	}

}
