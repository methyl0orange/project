package com.oracle.sport.color;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.sport.mapper.ColorMapper;
import com.oracle.sport.po.Color;
@Service("colorService")
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorMapper colorMapper;
	
	public List<Color> selectAllColor() {
		
		return colorMapper.selectAllColor();
	}

}
