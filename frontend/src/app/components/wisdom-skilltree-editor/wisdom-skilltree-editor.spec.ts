import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WisdomSkilltreeEditor } from './wisdom-skilltree-editor';

describe('WisdomSkilltreeEditor', () => {
  let component: WisdomSkilltreeEditor;
  let fixture: ComponentFixture<WisdomSkilltreeEditor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WisdomSkilltreeEditor],
    }).compileComponents();

    fixture = TestBed.createComponent(WisdomSkilltreeEditor);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
