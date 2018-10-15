package com.lucas.sandgrain.idgenerator.domain.model.id;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.lucas.sandgrain.idgenerator.domain.model.id.Id;
import com.lucas.sandgrain.idgenerator.domain.model.instance.DataCenterNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class IdTest {

	public Object[][] parametersToTestIdAssemble() {
		return new Object[][] {
			new Object[] {16917051000L,new DataCenterNamespace(2L),new InstanceNamespace(26),37L,70955254678034981L}
		};
	}
	
	@Test
	@Parameters(method = "parametersToTestIdAssemble")
	public void shouldAssembleId(long ts,DataCenterNamespace dc,InstanceNamespace inst,long currSeqVal,long expectedId) {
		Id id = new Id(ts,dc,inst,currSeqVal);
		
		assertThat(id.toLong(),equalTo(expectedId));
	}
	
}
