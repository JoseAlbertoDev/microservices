/******************************************************************************
 * 
 *  $Id$
 * 
 * Copyright 2018 INGENIA S.A. All rights reserved.
 * 
 * $Date$ 
 * $Revision$
 * $URL$ 
 * $Author$ 
 * 
 * Fecha creación 2 mar. 2018
 * 
 * @autor jamartin
 *
 *
 * ***************************************************************************/
package org.alberto.ingenia.auth.model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

/**
 * @author jamartin
 *
 */
@Document(collection = "clientes")
public class Cliente implements ClientDetails {
	
	private static final long serialVersionUID = -8908217978820206005L;
	
	private String clientId;
	private String clientSecret;
	private Set<String> scope;
	private Set<String> resourceIds;
	private Set<String> authorizedGrantTypes;
	private Set<String> registeredRedirectUri;
	private Collection<GrantedAuthority> authorities;
	private Integer accessTokenValiditySeconds;
	private Integer refreshTokenValiditySeconds;
	private Map<String, Object> additionalInformation;
	private Set<String> autoApproveScopes;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String clientId, String clientSecret, String scope, String resourceIds, 
			String authorizeGrantTypes, String authorities,
			Integer accessTokenValiditySeconds, Integer refreshTokenValiditySeconds) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
		if (StringUtils.hasText(scope)) {
			Set<String> setScope = StringUtils.commaDelimitedListToSet(scope);
			if (!setScope.isEmpty()) {
				this.scope = setScope;
			}
		}
		if (StringUtils.hasText(resourceIds)) {
			Set<String> setResourceids = StringUtils.commaDelimitedListToSet(resourceIds);
			if (!setResourceids.isEmpty()) {
				this.resourceIds = setResourceids;
			}
		}
		if (StringUtils.hasText(authorizeGrantTypes)) {
			Set<String> setAuthorizeGrantTypes = StringUtils.commaDelimitedListToSet(authorizeGrantTypes);
			if (!setAuthorizeGrantTypes.isEmpty()) {
				this.authorizedGrantTypes = setAuthorizeGrantTypes;
			}
		}
		if (StringUtils.hasText(authorities)) {
				this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
		}
	}
	
	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		return resourceIds;
	}

	@Override
	public boolean isSecretRequired() {
		return clientSecret != null && !clientSecret.isEmpty();
	}
	
	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	@Override
	public boolean isScoped() {
		return scope != null && !scope.isEmpty();
	}

	@Override
	public Set<String> getScope() {
		return scope;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	
	@Override
	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		if (autoApproveScopes == null) {
			return false;
		}
		for (String auto : autoApproveScopes) {
			if (auto.equals("true") || scope.matches(auto)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Map<String, Object> getAdditionalInformation() {
		return additionalInformation;
	}
}
