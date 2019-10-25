package com.science.com.rchs.di.presenter;

import java.util.Map;

/**
 * @ProjectName: movie
 * @ClassName: BaseInterface
 * @Description: java类作用描述
 * @Author: 刘继超
 * @CreateDate: 2019/5/13 14:31:44
 */
public class BaseInterface {
    public interface PInterface{
        public void Login(String url, Map<String, String> map, Class aClass);
        public void Regist(String url, Map<String, String> map, Class aClass);
        public void HotMovie(String url, Map<String, String> map, Class aClass);
        public void HotFrag(String url, Map<String, String> map, Class aClass);
        public void ReleaseMovie(String url, Map<String, String> map, Class aClass);
        public void ReleaseFrag(String url, Map<String, String> map, Class aClass);
        public void ComingSoonMovie(String url, Map<String, String> map, Class aClass);
        public void ComingFrag(String url, Map<String, String> map, Class aClass);
        public void FilmFqy(String url, Map<String, String> map, Class aClass);
        public void FilmFyp(String url, Map<String, String> map, Class aClass);
        public void FilmPl(String url, Map<String, String> map, Class aClass);
        public void OnDestory();
    }
    public interface LoginInterface{
        public  void Success(Object o);
    }
    public interface RegistInterface{
        public  void Success(Object o);
    }
    public interface FilmInterface{
        public void HotSuccess(Object o);
        public void ReleaseSuccess(Object o);
        public void ComingSoonSuccess(Object o);
    }
    public interface HotInterface{
        public void HotSuccess(Object o);
    }
    public interface ReleaseInterface{
        public void ReleaseSuccess(Object o);
    }
    public interface ComingInterface{
        public void ComingSoonSuccess(Object o);
    }
    public interface XqyInterface{
        public void XqySuccess(Object o);
        public void YpSuccess(Object o);
        public void PlSuccess(Object o);

    }


}
