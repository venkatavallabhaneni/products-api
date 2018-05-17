package com.venkata.vallabhaneni;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.venkata.vallabhaneni.domain.Product;

public class ProductServiceImplTest {

	@Mock
	private ProductsDao daoMock;

	@InjectMocks
	private ProductsServiceImpl serviceMock;

	Product aProduct = null;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		aProduct = mock(Product.class);
		aProduct.setName("Bannana");
		aProduct.setId(101L);
	}

	@Test
	public void shouldReturnProductsList_whenFindAllIsCalled() {

		List<Product> list = new ArrayList<Product>();
		list.add(aProduct);

		when(daoMock.findAll()).thenReturn(list);

		assertArrayEquals(serviceMock.findAll().toArray(), list.toArray());
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullpointerException_whenFindAllIsCalled_andServiceIsNull() {

		when(daoMock.findAll()).thenThrow(NullPointerException.class);
		serviceMock.findAll();
	}

	@Test
	public void shouldReturnProduct_101_whenFindByIdIsCalled() {

		when(daoMock.findById(101L)).thenReturn(Optional.of(aProduct));
		assertEquals(serviceMock.findById(101L), Optional.of(aProduct));
	}

	@Test
	public void shouldReturnProduct_Null_whenFindByIdIsCalled_with102() {

		when(daoMock.findById(102L)).thenReturn(Optional.empty());
		assertEquals(serviceMock.findById(102L), Optional.empty());
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowException_whenSaveIsCalledWithNullArgument() {

		when(daoMock.save(null)).thenThrow(IllegalArgumentException.class);
		serviceMock.persist(null);
	}

	@Test
	@Ignore
	public void shouldReturnProduct_whenSaveIsCalled() {

		when(daoMock.save(any(Product.class))).thenAnswer(new Answer<Product>() {
			@Override
			public Product answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();

				System.out.println(arguments);
				if (arguments != null && arguments.length > 0 && arguments[0] != null) {
					Product aProduct = (Product) arguments[0];
					aProduct.setId(102L);
					aProduct.setName("Lemon");
					return aProduct;
				}
				return null;
			}
		});

		assertEquals(serviceMock.persist(aProduct).getName(), "Lemon");

	}

}
