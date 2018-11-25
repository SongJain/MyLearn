
public interface Subject {
	public void registerObserver(Observer o);		//注册观察者
	public void removeObserver(Observer o);			//移除观察者
	
	public void notifyOvbserver();					//通知观察者
}
