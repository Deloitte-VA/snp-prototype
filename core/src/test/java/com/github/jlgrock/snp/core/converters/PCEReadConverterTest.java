package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PCETags;
import com.github.jlgrock.snp.core.domain.PCE;
import com.mongodb.DBObject;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class PCEReadConverterTest {

    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(PCETags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(PCETags.DESCRIPTION_TAG)).thenReturn("bla");

        PCEReadConverter patientReadConverter = new PCEReadConverter();
        PCE pce = patientReadConverter.convert(dbObj);

        assertEquals((Long) 123l, pce.getId());
        assertEquals("bla", pce.getDesc());
    }
}
