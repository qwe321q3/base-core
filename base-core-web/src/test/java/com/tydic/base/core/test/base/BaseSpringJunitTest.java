
package com.tydic.base.core.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;

/**
 * @author Administrator
 * @version Id: BaseSpringJunitTest.java, v 0.1 2016/7/29 0029 17:12 Administrator Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public abstract class BaseSpringJunitTest extends TestCase {

}