import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemEditor } from './item-editor';

describe('ItemEditor', () => {
  let component: ItemEditor;
  let fixture: ComponentFixture<ItemEditor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ItemEditor],
    }).compileComponents();

    fixture = TestBed.createComponent(ItemEditor);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
