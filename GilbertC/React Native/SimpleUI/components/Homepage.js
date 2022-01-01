import React from 'react';
import { Text,View,SafeAreaView,Image, FlatList } from 'react-native';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import { Colors } from 'react-native/Libraries/NewAppScreen';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';
import styles from './stylesHomepage';
import colors from '../assets/colors/colors';
import { SearchBar } from 'react-native-screens';

Feather.loadFont();

export default function App() {

    const renderCategoryItems = ({ item }) => {
        return (
            <View
                style={[styles.categoryItemWrapper,
                    {
                        backgroundColor: item.selected ? colors.primary : colors.white,
                        marginLeft:item.id == 1 ? 20:0,
                    },
                ]}>
                <Image source={item.image} style={styles.categoryItemImage} />
                <Text style={styles.categoryItemTitle}>{item.title}</Text>
                <View
                    style={[
                        styles.categorySelectWrapper,
                        {
                            backgroundColor: item.selected? colors.white:colors.secondary,
                        },
                    ]}>
                    <Feather 
                        name="chevron-right"
                        size={15}
                        style={styles.categorySelectIcon}
                        color={item.selected ? colors.black : colors.white}
                        />
                </View>
            </View>
        );
    };

    return(
        <View style={styles.container}>
            <SafeAreaView>
                <View style={styles.headerWrapper}>
                    {/* Header */}
                    <Image 
                        source={require('../assets/images/profile.png')}
                        style={styles.profileImage}/>
                    <Feather name="menu" size={24} color={colors.textDark}/>                    
                </View>
            </SafeAreaView>

            {/* Titles */}
            <View style={styles.titlesWrapper}>
                <Text style={styles.titlesSubtitle}>Food</Text>
                <Text style={styles.titlesTitle}>Delivery</Text>
            </View>

            {/* Search */}
            <View style={styles.searchWrapper}>
                <Feather name="search" size={16} color={colors.textDark} />
                <View style={styles.search}>
                    <Text style={styles.searchText}>Search.. </Text>
                </View>
            </View>

            {/* Categories */}
            <View style={styles.categoryWrapper}>
                <Text style={styles.categoryTitle}>Categories</Text>
                <View style={styles.categoryListWrapper}>
                    <FlatList
                        data={categoriesData}
                        renderItem={renderCategoryItems}
                        keyExtractor={item => item.id}
                        horizontal={true}
                        showsHorizontalScrollIndicator={false}
                        />
                </View>
            </View>


        </View>
    );
};