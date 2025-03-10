package mvc.controller;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

import java.util.List;


/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
	 private ElectronicsService service = ElectronicsServiceImpl.getInstance();

    /**
     * 전체검색
     */
    public void selectAll() {
        List<Electronics> list = service.selectAll();
        if (list.isEmpty()) {
            FailView.errorMessage("등록된 전자제품이 없습니다.");
        } else {
            SuccessView.printAll(list);
        }
    }
 

	 /**
     * 전자제품 등록 
     */
   
    public void insert(Electronics electronics) {
        try {
            service.insert(electronics);
            SuccessView.printMessage("전자제품 등록에 성공하였습니다.");
        } catch (ElectronicsArrayBoundsException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
        try {
            Electronics electronics = service.searchByModelNo(modelNo);
            SuccessView.printSearchByModelNo(electronics);
        } catch (SearchNotFoundException e) {
            FailView.errorMessage(e.getMessage());
        }
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
        try {
            service.update(electronics);
            SuccessView.printMessage("전자제품 정보 수정에 성공하였습니다.");
        } catch (SearchNotFoundException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기 
     * @param:electronics
     */
	public void deleteModelNo(int modelNo) {
        try {
            service.delete(modelNo);
            SuccessView.printMessage("전자제품 삭제에 성공하였습니다.");
        } catch (SearchNotFoundException e) {
            FailView.errorMessage(e.getMessage());
        }
	}
	
	/**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public void selectSortByPrice() {
        List<Electronics> sortedList = service.selectSortByPrice();
        if (sortedList.isEmpty()) {
            FailView.errorMessage("등록된 전자제품이 없습니다.");
        } else {
            SuccessView.printAll(sortedList);
        }
    }
}











