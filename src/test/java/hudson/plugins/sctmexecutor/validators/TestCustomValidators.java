package hudson.plugins.sctmexecutor.validators;

import static org.junit.Assert.*;
import hudson.util.FormValidation;

import org.junit.Test;


public class TestCustomValidators {
  @Test
  public void testEmptySingleFieldValidator() throws Exception {
    FormValidation fv = new EmptySingleFieldValidator().check(null);
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new EmptySingleFieldValidator().check("");
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new EmptySingleFieldValidator().check("blafasl");
    assertEquals(FormValidation.Kind.OK, fv.kind);
  }
  
  @Test
  public void testNumberCSVSingleFieldValidator() throws Exception {
    FormValidation fv = new NumberCSVSingleFieldValidator().check(null);
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new NumberCSVSingleFieldValidator().check("");
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new NumberCSVSingleFieldValidator().check("dfsdfsdf");
    assertEquals(FormValidation.Kind.ERROR, fv.kind);
    
    fv = new NumberCSVSingleFieldValidator().check("1");
    assertEquals(FormValidation.Kind.OK, fv.kind);
    
    fv = new NumberCSVSingleFieldValidator().check("1,2,3");
    assertEquals(FormValidation.Kind.OK, fv.kind);
  }
}
