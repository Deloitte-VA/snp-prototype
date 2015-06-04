package com.github.jlgrock.snp.core.domain.lego.marhsallers;

import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import org.jvnet.hk2.annotations.Contract;

import java.io.Reader;

/**
 *
 */
@Contract
public interface LegoMarshallerService {
    public Object unmarshall(final String input) throws UnmarshallingException;

    public Object unmarshall(final Reader input) throws UnmarshallingException;
}
