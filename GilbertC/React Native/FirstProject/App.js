/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////// props tuk tampil nama bbrp kali dgn style yg sama (tdk perlu tulis style yg sama terusmenerus) //////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

const styles = StyleSheet.create({
  center: {
    alignItems: 'center'
  }
})

const Greeting = (props) => {
  return (
    <View style = {styles.center}>
      <Text>Hello {props.name}!</Text>
    </View>
  );
}

const LotsOfGreetings = () => {
  return(
    <View style={[styles.center, {top:100}]}>
      <Greeting name='Rexxer' />
      <Greeting name='Jaina'/>
      <Greeting name='Valeera'/>
    </View>
  );
}

export default LotsOfGreetings;
*/


///////////////////////////////////
/////// state klik tombol+1 ///////
///////////////////////////////////
/*
import React, { Component } from 'react'
import {
  StyleSheet,
  TouchableOpacity,
  Text,
  View,
} from 'react-native'

class App extends Component {
  state = {
    count: 0
  }

  onPress = () => {
    this.setState({
      count: this.state.count+1
    })
  }

  render(){
    return(
      <View style={styles.container}>
        <TouchableOpacity
        style={styles.button}
        onPress={this.onPress}
        >
          <Text>Click Me</Text>
        </TouchableOpacity>
        <View>
          <Text>
            You clicked { this.state.count } times
          </Text>
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex:1 ,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    alignItems: 'center',
    backgroundColor: '#DDDDDD',
    padding: 10,
    marginBottom: 10
  }
})

export default App;
*/


/////////////////////////////
/////// state + props ///////
/////////////////////////////

import React, { useState } from "react";
import {Button, Text, View} from "react-native";

const Cat = (props) => {
  const [isHungry, setIsHungry] = useState(true);

  return(
    <View>
      <Text>
        Im {props.name}, and im {isHungry ? "hungry" : "full"}!
      </Text>
      <Button
        onPress={() => {
          setIsHungry(false);
        }}
        disabled={!isHungry}
        title={isHungry ? "Pour me some milk, please!" : "Thank you!"}
        />
    </View>
  );
}

const Cafe = () => {
  return (
    <>
    <Cat name="Munkustrap" />
    <Cat name="Spot"/>
    </>
  ); 
}

export default Cafe;



////////////////////////////////////
/////// handling text input ////////
////////////////////////////////////
/*
import React, { useState } from 'react';
import { Text, TextInput, View } from 'react-native';

const PizzaTranslator = () => {
  const [text, setText] = useState('');

  return (
    <View style={{padding:10}}>
      <TextInput
        style={{height:40}}
        placeholder="Type here to translate!"
        onChangeText={text => setText(text)}
        defaultValue={text}
      />
      <Text style={{padding:10, fontSize:42}}>
        {text.split(' ').map((word) => word && '🍕').join(' ')}
      </Text>
    </View>
  );
}

export default PizzaTranslator
*/


///////////////////////////
/////// Scroll View ///////
///////////////////////////
/*
import React from 'react';
import {Text, Image, ScrollView} from 'react-native';

const logo = {
  uri: 'https://reactnative.dev/img/tiny_logo.png',
  width: 64,
  height: 64
};

const App = () => (
  <ScrollView>
    <Text style={{fontSize:96}}>Scroll me pls</Text>
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Text style={{fontSize:96}}>If you like</Text>
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Text style={{fontSize:96}}>Scrolling down</Text>
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
    <Image source={logo} />
  </ScrollView>
);

export default App;
*/


////////////////////////////////////////
/////// List View using FlatList ///////
////////////////////////////////////////
/*
import React from 'react';
import {Text, FlatList, StyleSheet, View} from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex:1,
    paddingTop:22
  },
  item: {
    padding:10,
    fontSize:18,
    height:44,
  }
});

const FlatListBasics = () => {
  return (
    <View style={styles.container}>
      <FlatList
        data={[
          {key: 'Devin'},
          {key: 'Dan'},
          {key: 'Dominic'},
          {key: 'Jackson'},
          {key: 'James'},
          {key: 'Joel'},
          {key: 'John'},
          {key: 'Jillian'},
          {key: 'Jimmy'},
          {key: 'Julie'},
          {key: 'Devin1'},
          {key: 'Dan1'},
          {key: 'Dominic1'},
          {key: 'Jackson1'},
          {key: 'James1'},
          {key: 'Joel1'},
          {key: 'John1'},
          {key: 'Jillian1'},
          {key: 'Jimmy1'},
          {key: 'Julie1'},
        ]}
        renderItem = {({item}) => <Text style={styles.item}>{item.key}</Text>}
      />
    </View>
  );
}

export default FlatListBasics;
*/


/////////////////////////////////
/////// SectionList Basic ///////
/////////////////////////////////
/*
import React from 'react';
import { Text, SectionList, StyleSheet, View } from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop:22
  },
  sectionHeader: {
    paddingTop:2,
    paddingLeft:10,
    paddingRight:10,
    paddingBottom:2,
    fontSize:14,
    fontWeight:'bold',
    backgroundColor: 'rgba(225,225,225,1.0)',
  },
  item: {
    padding:10,
    fontSize:18,
    height:44,
  },
})

const SectionListBasics = () => {
  return (
    <View style = {styles.container}>
      <SectionList
        sections = {[
          {title: 'D', data: ['Devin','Dan','Dominic']},
          {title: 'J', data: ['Jackson','James','Jillian','Jimmy']}
        ]}
        renderItem={({item}) => <Text style={styles.item}>{item}</Text>}
        renderSectionHeader={({section}) => <Text style={styles.sectionHeader}>{section.title}</Text>}
        keyExtractor={(item,index)=>index}
      />
    </View>
  );
}

export default SectionListBasics;
*/


/////////////////////
/////// style ///////
/////////////////////
/*
import React from 'react';
import {Text, StyleSheet, View} from 'react-native';

const LotsOfStyles = () => {
  return(
    <View style={styles.container}>
      <Text style={styles.red}>just red</Text>
      <Text style={styles.bigBlue}> just bigBlue</Text>
      <Text style={[styles.bigBlue, styles.red]}>bigBlue and then red</Text>
      <Text style={[styles.red, styles.bigBlue]}>red and then bigBlue</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop:50,
  },
  bigBlue: {
    color:'blue',
    fontWeight:'bold',
    fontSize:30,
  },
  red:{
    color:'red',
  },
});

export default LotsOfStyles;
*/


////////////////////////////////
/////// Fixed Dimensions ///////
////////////////////////////////
/*
import React from 'react';
import {View} from 'react-native';

const FixedDimensionsBasics = () => {
  return(
    <View>
      <View style= {{
        width:50, height:50, backgroundColor: 'powderblue'
      }}/>
      <View style= {{
        width:100, height:100, backgroundColor: 'skyblue'
      }}/>
      <View style= {{
        width:150, height:150, backgroundColor: 'steelblue'
      }}/>
    </View>
  );
};

export default FixedDimensionsBasics;
*/


///////////////////////////////
/////// Flex Dimensions ///////
///////////////////////////////
/*
import React from 'react';
import {View} from 'react-native';

const FlexDimensionsBasics = () => {
  return(
    <View style={{flex:1}}>
      <View style={{flex:1, backgroundColor: 'powderblue'}}/>
      <View style={{flex:2, backgroundColor: 'skyblue'}}/>
      <View style={{flex:3, backgroundColor: 'steelblue'}}/>
    </View>
  );
};

export default FlexDimensionsBasics;
*/





