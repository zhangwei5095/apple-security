package com.appleframework.security.auth.client;

import java.util.List;

import com.appleframework.security.auth.client.store.ClientDetailsStore;
import com.appleframework.security.core.client.ClientDetails;
import com.appleframework.security.core.client.ClientDetailsService;
import com.appleframework.security.core.exception.ClientRegistrationException;


public class DefaultClientDetailsService implements ClientDetailsService {

	private ClientDetailsStore clientDetailsStore;
	
	
	public void setClientDetailsStore(ClientDetailsStore clientDetailsStore) {
		this.clientDetailsStore = clientDetailsStore;
	}


	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		ClientDetails clientDetails = clientDetailsStore.loadClientByClientId(clientId);
		if(null == clientDetails)
			throw new ClientRegistrationException(clientId);
		return clientDetailsStore.loadClientByClientId(clientId);
	}

	@Override
	public List<ClientDetails> findAll() {
		return clientDetailsStore.findAll();
	}


	@Override
	public ClientDetails loadClientByAdditionalInformation(String additionalInformation)
			throws ClientRegistrationException {
		return null;
	}
		
}
