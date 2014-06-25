package hudson.plugins.sctmexecutor.validators;

import static org.junit.Assert.assertEquals;
import hudson.util.FormValidation;

import org.junit.Test;


public class TestCustomValidators {
  
  @Test
  public void testNumberListSingleFieldValidator() throws Exception {
    FormValidation fv = new NumberListSingleFieldValidator().check(null);
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new NumberListSingleFieldValidator().check("");
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new NumberListSingleFieldValidator().check("dfsdfsdf");
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new NumberListSingleFieldValidator().check("1");
    assertEquals(FormValidation.Kind.OK, fv.kind);
    
    fv = new NumberListSingleFieldValidator().check("1,2,3");
    assertEquals(FormValidation.Kind.OK, fv.kind);
    
    fv = new NumberListSingleFieldValidator().check("1 2 3");
    assertEquals(FormValidation.Kind.OK, fv.kind);
  }
}
