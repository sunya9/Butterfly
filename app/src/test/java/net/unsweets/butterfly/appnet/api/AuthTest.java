package net.unsweets.butterfly.appnet.api;

import net.unsweets.butterfly.BuildConfig;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthTest {

  private Auth auth;

  @Test
  public void requireClientId() throws Exception {
    assertNotEquals(BuildConfig.APP_DOT_NET_CLIENT_ID, "");
  }

  @Test
  public void doesNotRequireClientSecret() throws Exception {
    assertEquals(BuildConfig.APP_DOT_NET_CLIENT_SECRET, "");
  }

  @Before
  public void setUp() throws Exception {
    auth = new Auth();
  }
}
