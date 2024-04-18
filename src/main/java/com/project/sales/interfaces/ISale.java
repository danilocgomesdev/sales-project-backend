package com.project.sales.interfaces;

import com.project.sales.model.Sale;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ISale<T, N> extends IGenericOperations<T, N> {
}
