package virtualPet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void shouldChangeWithTick() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(1);
		Assert.assertEquals(1, underTest.hunger);
	}
	
	@Test
	public void shouldStillChangeWithTick() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(1);
		underTest.tick(1);
		Assert.assertEquals(2, underTest.hunger);
	}
	
	@Test
	public void shouldRepeatTick() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(2);
		Assert.assertEquals(2, underTest.hunger);
	}
	
	@Test
	public void shouldFeed() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(20);
		underTest.feed(1);
		Assert.assertEquals(5, underTest.hunger);
	}
	
	@Test
	public void shouldStillFeed() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(30);
		underTest.feed(1);
		Assert.assertEquals(15, underTest.hunger);
	}
	
	@Test
	public void shouldGetTiredAfterPlay() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(20);
		underTest.play();
		Assert.assertEquals(30, underTest.tiredness);
	}
	
	@Test
	public void shouldStillGetTiredAfterPlay() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.tick(30);
		underTest.play();
		Assert.assertEquals(40, underTest.tiredness);
	}
	
	@Test
	public void shouldNotDropBelowZero() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat");
		underTest.feed(2);
		underTest.tick(1);
		Assert.assertEquals(0, underTest.hunger);
	}
	
}
