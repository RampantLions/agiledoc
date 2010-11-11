package sourceagile.testing.client;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * Test Class: TestClassDescription. Show the specification of the Test Class.
 * 
 */
public class TestClassDescriptionTest extends GWTTestCase {

	@Override
	public String getModuleName() {

		return "sourceagile.SourceAgile";
	}

	public void testTestClassDescription() {

		ClassFile classEntry = null;

		ClassFile testEntry = null;

		new TestClassDescription(classEntry, testEntry);

		assertTrue(true);
	}

}
