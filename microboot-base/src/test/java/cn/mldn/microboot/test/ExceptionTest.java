package cn.mldn.microboot.test;

import org.junit.Test;

public class ExceptionTest {
	@Test
	public void saveData() {
		try {
			System.out.println("开始");
			System.out.println("当前线程名称1：" + Thread.currentThread().getName());
			saveOne();
			saveSecond();
			saveThird();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("当前线程名称2：" + Thread.currentThread().getName());
		}
		System.out.println("khh");
	}

	private void saveOne(){
		try {
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveSecond() throws Exception{
			System.out.println(1 / 0);
			System.out.println("ok2");
			
	}

	private void saveThird() {
		try {
			System.out.println("ok3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
