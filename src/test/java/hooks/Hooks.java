package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

	@Before("@SpecificHook")
	public void specificHook() {
		System.out.println("This hook is specific for as list scenario");
	}

	@Before(order = 1)
	public void firstBeforeHook() {
		System.out.println("This hook is first before hook");
	}

	@Before(order = 2)
	public void secondBeforeHook() {
		System.out.println("This hook is second Before hook");
	}

	@Before(order = 3)
	public void thirdBeforeHook() {
		System.out.println("This hook is third before hook");
	}

//	for after hook order of execution will be from higher number to lower number
	@After(order = 3)
	public void firstAfterHook() {
		System.out.println("This is first Afterhook");
	}

	@After(order = 2)
	public void secondAfterHook() {
		System.out.println("This is second afterhook");
	}

	@After(order = 1)
	public void thirdAfterHook() {
		System.out.println("This is third After Hook");
	}

	@BeforeStep
	public void BeforeStepHook() {
		System.out.println("This is before step");
	}

	@AfterStep
	public void AfterStepHook() {
		System.out.println("This is after step");
	}
}
