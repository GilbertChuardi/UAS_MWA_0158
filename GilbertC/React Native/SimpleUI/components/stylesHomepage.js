import {Text,StyleSheet} from 'react-native';
import colors from '../assets/colors/colors';

const styles = StyleSheet.create({
    container:{
        flex:1,
    },
    headerWrapper: {
        flexDirection:'row',
        justifyContent:'space-between',
        paddingHorizontal:30,
        paddingTop:25,
        alignItems:"center",
    },
    profileImage:{
        width:40,
        height:40,
        borderRadius:40,
    },
    titlesWrapper:{
        marginTop:25,
        paddingHorizontal:20,
    },
    titlesSubtitle:{
        fontFamily:'Montserrat-Regular',
        fontSize:16,
        color:colors.textDark,
    },
    titlesTitle:{
        fontFamily:'Montserrat-Bold',
        fontSize:32,
        color:colors.textDark,
    },
    searchWrapper: {
        flexDirection: 'row',
        alignItems: 'center',
        paddingHorizontal:20,
        marginTop:20,
    },
    search:{
        flex:1,
        marginLeft:10,
        borderBottomColor:colors.textDark,
        borderBottomWidth:2,
    },
    searchText:{
        fontFamily: 'Montserrat-SemiBold',
        fontSize:14,
        marginBottom:5,
        color:colors.textLight,
    },
    categoryWrapper:{
        marginTop:25,
    },
    categoryTitle:{
        fontFamily:'Montserrat-Bold',
        fontSize:16,
        paddingHorizontal:20,
    },
    categoryListWrapper:{
        paddingTop:15,
        paddingBottom:20,
    },
    categoryItemWrapper: {
        backgroundColor: '#f5ca48',
        marginRight:20,
        borderRadius:20,
    },
    categoryItemImage: {
        width:60,
        height:60,
        marginTop:15,
        alignSelf:'center',
        marginHorizontal:15,
    },
    categoryItemTitle: {
        textAlign:'center',
        fontFamily:'Montserrat-SemiBold',
        fontSize:14,
        marginTop:5,
    },
    categorySelectWrapper:{
        alignSelf:'center',
        justifyContent:'center',
        marginTop:15,
        width:26,
        height:26,
        borderRadius:26,
        marginBottom:15,
    },
    categorySelectIcon: {
        alignSelf:'center',
    }


});

export default styles;