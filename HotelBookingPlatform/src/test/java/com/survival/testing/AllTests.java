package com.survival.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DeletePackageTest.class, InsertPackageTest.class, SearchPackageTest.class })
public class AllTests {

}
