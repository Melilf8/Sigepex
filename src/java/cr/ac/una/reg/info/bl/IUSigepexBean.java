/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class IUSigepexBean {
    private String idIU;
    private String aliasIU;
    private String msg;
    private List list_ins_iuSigepexBean;

    /*  CONSTRUCTORES */
    public IUSigepexBean() {
        this.idIU = "";
        this.aliasIU = "";
        this.msg = "";
        this.list_ins_iuSigepexBean = new ArrayList();
    }

    public IUSigepexBean(String pIdIU, String pAliasIU, String pMsg, List pList_ins_iuSigepexBean) {
        this.idIU = pIdIU;
        this.aliasIU = pAliasIU;
        this.msg = pMsg;
        this.list_ins_iuSigepexBean = pList_ins_iuSigepexBean;
    }

    /* PROPIEDADES */
    public String getIdIU() { return idIU; }
    public void setIdIU(String idIU) { this.idIU = idIU; }
    public String getAliasIU() { return aliasIU; }
    public void setAliasIU(String aliasIU) { this.aliasIU = aliasIU; }
    public String getMsg() {  return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public List getList_ins_iuSigepexBean() { return list_ins_iuSigepexBean; }
    public void setList_ins_iuSigepexBean(List pList_ins_iuSigepex) { this.list_ins_iuSigepexBean = pList_ins_iuSigepex; }

}
