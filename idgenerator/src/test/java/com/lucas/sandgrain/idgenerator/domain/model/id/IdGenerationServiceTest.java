package com.lucas.sandgrain.idgenerator.domain.model.id;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.lucas.sandgrain.idgenerator.domain.model.id.IdGenerationService;
import com.lucas.sandgrain.idgenerator.domain.model.instance.DataCenterNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.NoInstanceNamespaceAvailableException;
import com.lucas.sandgrain.idgenerator.domain.model.instance.SingleInstanceNamespaceAccessor;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.SequenceRegistry;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.TwelveBitSequenceFactory;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;
import com.lucas.sandgrain.idgenerator.infrastructure.time.BackShiftWaitStrategy;
import com.lucas.sandgrain.idgenerator.infrastructure.time.OnlyIncreasingTimestampRetriever;
import com.lucas.sandgrain.idgenerator.infrastructure.time.SystemTimeInMillisRetriever;

public class IdGenerationServiceTest {

	private IdGenerationService idGenerationService;
	
	@Before
	public void setUp() {
		SystemTimeInMillisRetriever timeInMillisRetriever = 
				new SystemTimeInMillisRetriever();
		
		idGenerationService = new IdGenerationService(
				new SequenceRegistry(
						new TwelveBitSequenceFactory()),
				new OnlyIncreasingTimestampRetriever(
						timeInMillisRetriever,
						new BackShiftWaitStrategy(
								timeInMillisRetriever)),
				new SingleInstanceNamespaceAccessor(new InstanceNamespace(21)),
				new DataCenterNamespace(12));
	}
	
	@Test
	public void shouldGenerateAnUniqueId() throws TimestampRetrievalException {
		final int AMOUNT_OF_IDS = 10000000;
		long[] ids = new long[AMOUNT_OF_IDS];
		long start = System.nanoTime();
		long noInstanceAvCount = 0;
		for(int i=0;i < AMOUNT_OF_IDS;i++) {
			try {
				ids[i] = idGenerationService.generate().toLong();
			} catch (NoInstanceNamespaceAvailableException e) {
				noInstanceAvCount++;
				i--;
			}
		}
		long end = System.nanoTime();
		System.out.println("Total: "+(end-start));
		Set<Long> idsSet = new HashSet<Long>(AMOUNT_OF_IDS);
		for(int i=0;i < AMOUNT_OF_IDS;i++) {
			idsSet.add(ids[i]);
		}
		System.out.println("Unique Id Ammount: "+idsSet.size());
		System.out.println("No Instance Available Count: "+noInstanceAvCount);
		
		for(int i=0;i < AMOUNT_OF_IDS;i++) {
			System.out.println(ids[i]);
		}
		
		/*
		List<String> idsList = new ArrayList<String>(AMOUNT_OF_IDS);
		for(int i=0;i < AMOUNT_OF_IDS;i++) {
			idsList.add(ids[i]);
		}
		Map<Long,Long> idToCountMap = new HashMap<Long,Long>(AMOUNT_OF_IDS);
		for(int i=0;i < idsList.size();i++) {
			long count = 0;
			for(int j=0;j < idsList.size();j++) {
				if(idsList.get(i).equals(idsList.get(j)))
					count++;
			}
			System.out.println(idsList.get(i)+":"+count);
			idToCountMap.put(idsList.get(i), count);
		}
		*/
	}
	
}
