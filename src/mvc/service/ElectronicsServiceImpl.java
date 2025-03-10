package mvc.service;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.view.SuccessView;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//dbInfo.properties
        for(String key : rb.keySet()) {
     	  String value =  rb.getString(key);
     	   String data[] = value.split(",");
     	   //System.out.println(key +" = " + value);
     	  
     	     list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
     	    		 Integer.parseInt( data[2]), data[3]) );
     	  
        }
        
        //System.out.println(list);
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException {
		if (list.size() >= MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("배열의 길이를 초과하였습니다.");
		}
		// 추가
		list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {
		return new ArrayList<>(list);
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for (Electronics electronics : list) {
			if (electronics.getModelNo() == modelNo) {
				return electronics;
			}
		}
		throw new SearchNotFoundException(modelNo + "는 없는 모델입니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics model = searchByModelNo(electronics.getModelNo());
		model.setModelDetail(electronics.getModelDetail());
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		Electronics model = searchByModelNo(modelNo);
		if (model == null) {
			throw new SearchNotFoundException("모델을 찾을 수 없습니다.");
		}
		list.remove(model);
	}

	@Override
	public List<Electronics> selectSortByPrice() {
		return null;
	}


	// 이거 추가
	@Override
	public void saveObject() throws Exception {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("electronics.txt"))) {
			oos.writeObject(list);
		} catch (Exception e) {
			throw new Exception("파일 저장 중 오류 발생: " + e.getMessage());
		}
	}

} // 클래스 끝 