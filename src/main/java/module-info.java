/**
 * 描述: .
 * <p>
 *     Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 * @author jiac
 * @version 2022.04.0 2022/7/11:15:28
 * @since 2022.04.0
 */
module com.jcohy.sample {
	exports com.jcohy.sample.java9;
	// requires com.jcohy.sample;
	provides com.jcohy.sample.java9.DemoService with
			com.jcohy.sample.java9.DemoServiceImpl;
}
